/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * @author 
 */
package com.game.core;

import com.game.abstr.*;
import com.game.items.*;

/**
 * Táto trieda je konkrétnou implementáciou rozhrania Game, pričom táto trieda
 * je definovaná stavom hry. Obsahuje niekoľko členských premenných. Obsahuje
 * referencie na užívateľské rozhranie, parser, menu, aktuálnej miestnosti, batohu 
 * a vykresľovača.
 * @author Bingo Player
 */
public class GameImpl 
    implements Game
{
    // data
    private GameState stav;
    private UserInterface ui;
    private final Parser parser;
    private final Menu mainMenu;
    private Room currentRoom;
    private final Backpack batoh;
    private final Renderer drawer;
    private final GameMap mapa;
    
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy.
     */
    public GameImpl()
    {     
        // inicializuj room
        currentRoom = null;
         
        // gamestate - default 
        stav = GameState.QUIT;
        
        // novy parser
        parser = new ParserImpl();
        
        // novy user interface
        ui = new TextUI();
      
        // novy renderer
        drawer = new Renderer(); 
                
        // inicializuj batoh
        batoh = new BackpackImpl( 15 );
        
        // inicializuj historiu
        History.getHistory();
        
        // nacitaj polozku menu
        String[] polozky = { "Nova hra", "Ukoncit hru" };
        mainMenu = new Menu( polozky );
        
        // vytvor novu mapu
        mapa = new GameMap(21, 21);
    }
    
    /**
     * Metóda vráti aktuálny stav hry.
     * @return stav hry.
     */
    @Override
    public GameState getGameState()
    {
        return stav;
    }
    
    /**
     * Táto metóda slúži na nastavenie aktuálneho stavu hry. Na výber je možmé
     * nastaviť niekoľko stavov : PLAYING, GAMEOVER, SOLVED, QUIT.
     * @param stav Nový stav hry
     */
    @Override
    public void setGameState( GameState stav )
    {
        this.stav = stav;
    }
    
    /**
     * Táto metóda vráti referenciu na Parser.
     * @return parser.
     */
    public ParserImpl getParser()
    {
        return (ParserImpl)parser;
    }
    
    /**
     * Táto metóda vráti referenciu na užívateľské rozhranie.
     * @return užívateľské rozhranie.
     */
    @Override
    public UserInterface getUI()
    {
        return ui;
    }
    
    /**
     * Táto metóda vráti referenciu na aktuálnu mapu hry.
     * @return mapu hry.
     */
    public GameMap getGameMap()
    {
        return mapa;
    }
    
    /**
     * Táto metóda slúži na nastavenie aktuálneho užívateľského rozhrania.
     * @param ui Nové užívateľské rozhranie
     */
    @Override
    public void setUI( UserInterface ui ) throws NullPointerException
    {
        if( ui != null )
            this.ui = ui;
        else
            throw new NullPointerException();
    }
    
    /**
     * Táto metóda slúži na volanie konkrétneho Command-u. V závislosti na 
     * vstupnom parametri, ktorý predstavuje názov daného Command-u parser zistí,
     * či sa daný Command nachádza v jeho tabuľke príkazov. Následne ak Command
     * existuje, volaním metódy execute daného Command-u sa vykoná táto metóda.
     * Takisto sa ukladajú jednotlivé príkazy do histórie.
     * @param command Vstupný reťazec načítaný zo štandardného vstupu
     */
    @Override
    @SuppressWarnings("empty-statement")
    public void processCommand( String command )
    {
       if( parser.getCommand( command ) == null )
           ui.print( "Taky prikaz nepoznam.\n\n" );
       else
       {
           parser.getCommand(command).execute(this, command);
           if( command.toLowerCase().contains( "nacitaj" ) || command.toLowerCase().contains("uloz") )
               ;
           else
              History.getHistory().add( command );
       }
    }
    
    /**
     * Vráti referenciu na menu hry.
     * @return menu hry.
     */
    public Menu getMenu()
    {
        return mainMenu;
    }
    
    /**
     * Táto metóda slúži na inicializovanie hry, pričom sa vytvorí nové menu,
     * vytvoria sa všetky miestnosti, ktoré sú potrebnmé na správny beh hry.
     */
    @Override
    public void init() 
    {
        // inicializacia znamena sputenie menu 
        getMenu().setVisible( true );
        
        // renderuj menu
        getDrawer().render( this );    
        
        // vytvor miestnosti
        createRooms();
    }

    /**
     * Táto metóda volá metódu triedy UserInterface, ktorá číta vstupný reťazec
     * znakov zo vstupu.
     */
    @Override
    public void start() 
    {   
        // loop je nekonecny cyklus pokial je stav hry - PLAYING
        getUI().loop(this);
    }

    /**
     * Vráti referenciu na vykresľovač.
     * @return vykresľovač.
     */
    public Renderer getDrawer()
    {
        return drawer;
    }
    
    /**
     * Vráti referenciu na aktuálnu miestnosť, v ktorej sa hráč práve nachádza.
     * @return aktuálnu miestnosť.
     */
    @Override
    public Room getCurrentRoom() 
    {
        return currentRoom;
    }

    /**
     * Táto metóda slúži na nastavenie novej aktuálnej miestnosti, pričom sa 
     * testuje vstupný parameter, ktorý ak je referenciou na null, program
     * vypíše výnimku.
     * @param room Nová miestnosť
     * @throws NullPointerException
     */
    @Override
    public void setCurrentRoom(Room room) throws NullPointerException
    {
        // zobraz aktualne miestnosti
        if( room != null )
        {
            currentRoom = room;
            currentRoom.show( getUI() );
        }
        else 
            throw new NullPointerException();
    }
    
    /**
     * Táto metóda slúži pri reštarte hry na inicializáciu novej hry.
     */
    public void initLevels()
    {
        // vytvor nove miestnosti
        createRooms();
        
        // zmaz mapu
        getGameMap().clearMap();
    }
    
    /**
     * Táto metóda slúži na vytvorenie všetkých miestností potrebých na to, aby
     * hráč bol schopný hrať hru a za použitia scenára dojsť do ciela.
     */ 
    private void createRooms()
    {
        // vytvor miestnosti
        Room A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
        Room z, y, x, m, u, j, w, l, s, f;
        Room C1, C2, C3, C4, C5, C6, C7, S1, H1, F1;
        E = new RoomImpl("Tmava komora.... rozhliadas sa okolo seba... zistujes ze si sam...."
                + "mota sa ti hlava a nevies kde si... po chvili zistujes ze si v nejakom starom bunkri a nad tebou svieti stara lampa"
                + ", ktora sa hupe ako keby ju niekto stuchol... vidis odkaz napisany na stene: 'Najdi vychod odtialto!'"
                + "\n'Utec prec skor nez mozes. 'Dam ti malu napovedu : pouzi dvere smerom na sever.' ");
        J = new RoomImpl("Tazko sa ti chodi, ale to nevadi ... pred tebou je mozno odpoved ako sa zbavit tych hroznych okovov"
                + ". Pokus sa zistit co sa s tebou stalo...");
        m = new RoomImpl("Si v miestnosti, ktora trochu pripomina vojensky sklad.... skoro ako zo stredoveku.");
        D = new RoomImpl("Nevidis nic zvlastne, akurat nejaky potkan ti prave prebehol cez nohu. Ale co to ? Nieco sa blisti"
                + "...");
        F1 = new RoomImpl("Ziarovka uz skoro ani nesvieti. Poponahlaj sa !");
        A = new RoomImpl("Nieco tu cudne blika...mal by si to rychlo zistit !");
        x = new RoomImpl("Bordel ako v tanku ! Lepsie slova ma ani nenapadaju. Ako som sa tu vobec ocitol ?");
        z = new RoomImpl("medeny kluc", "Fuj tu nieco poriadne smrdi! Ako keby tu vybuchol tchor alebo nieco podobne..."
                + "\nNa stene nieco vidis. Je to napis. 'Ides spravne. Dokonci misiu a utec z tejto hnusnej diery!'");
        y = new RoomImpl("Tento smrad je na nevydrzanie. Musis z tejto hnusnej diery prec!");
        B = new RoomImpl("Smrad a voda ... vsade plavu potkany");
        C = new RoomImpl("Prazdna miestnost.");
        K = new RoomImpl("Akosi je tu privela priser. Musis sa o ne postarat inak ti nedaju pokoj.");
        L = new RoomImpl("Prazdna miestnost. Naco ju vobec stavali ? Nevidim tu skoro nic iba male svetielko nad"
                + " vedlajsimi dverami.");
        N = new RoomImpl("strieborny kluc", "Ale nie... nieco hrozne sa tu stalo. Mam nejake tusenie ze som sa ocitol v horore.");
        M = new RoomImpl("Divna chodba, ktora pokracuje dalej... svetlo cudne blika ... necitis sa tu dobre.");
        Q = new RoomImpl("Preliezla ti krysa po nohach... pre boha to je cudne miesto ...");
        R = new RoomImpl("Chodba pripomina skor stary bunker.");
        S = new RoomImpl("zlaty kluc", "Tajne dvere ti ukazali cestu dalej...Zacina to tu byt pekne tmave, radsej nech uz si von...");
        f = new RoomImpl("Zacina tu byt trochu tmave a pekelne strasidelne... Pocut aj zvuky z nizsieho poschodia...");
        s = new RoomImpl("Blikajuce svetlo... Nejako divne tu funguju tie ziarovky ?!");
        w = new RoomImpl("Miestnost je uplne prazdna... Akoby ju postavili len na to aby tu boli len hole mury. Napoveda : Pouzi baterku.");
        u = new RoomImpl("Pred tebou je vchod do akehosi skladu, kde vedu schody dole... Neviem ci je dobry napad tam ist.");
        j = new RoomImpl("Fakt som sem nemal ist, je tu hrozna zima a nesvieti tu svetlo... no super!");
        l = new RoomImpl("Tak a je to tu |");
        P = new RoomImpl("Dalsia chodba, ktora hadam vedie z tohto sialenstva prec...");
        O = new RoomImpl("Zas to blikajuce svetlo... mam pocit, ze tu elektrikari asi velmi neyarobili... a co to ?"
                + "Dalsie schodz smerom hroe... no lepsie ney smerom dole.");
        T = new RoomImpl("kovovy kluc", "Vidno velke svetlo, asi majak ? Nevidno nic iba hustu hmlu a svetlo ktore sa toci "
                + "okolo vlastnej osi...");
        U = new RoomImpl("Stale ten majak v mojom oku... To svetlo mi dava aj nadej aby som pokracoval dalej...");
        V = new RoomImpl("Hrozny neporiadok... nieco tu fakt nesedi, kde su upratovacky ?!");
        W = new RoomImpl("DANGER! Hm. Napis na dverach o niecom svedci...");
        X = new RoomImpl("Boom! Zasa ten smrad, boze odkial to ide ? Zeby z tej ventilacie?");
        Y = new RoomImpl("Stara cesta na strechu, hm ale je silne poskodena tadial sa hore nedostanem...");
        H = new RoomImpl("sekera", "Velka kopa dreva na zemi, ale asi tu niesi sam.");
        G = new RoomImpl("Hmm...kadial teraz ? Vanok vetra mi vravi ze na sever ... ale zdanie obcas klame..");
        I = new RoomImpl("Dalsia miestnosti... uz to ani nepocitam, je ich tu naozaj vela...");
        C1 = new RoomImpl("paka", "Velka chodba, ktora pokracuje dalej ... kde to len konci ?");
        C2 = new RoomImpl("Dalsia chodba ? Fiha to je divne !");
        C3 = new RoomImpl("Chodba, chodba, chodba...");
        S1 = new RoomImpl("Divna komora.");
        H1 = new RoomImpl("ultra kluc", "Pocut divne zvuky... vobec sa ti to nebude pacit.");
        C4 = new RoomImpl("Len dalsia chodba, ktora asi nikam nevedie...");
        C5 = new RoomImpl("Stale ta hnusna smradlava chodba, preco to proste urobili tak dlhe ?");
        C6 = new RoomImpl("No konecne vidno aj nieco ine okrem dalsej chodby... mam z toho zly pocit ...");
        C7 = new RoomImpl("sperhak","Tajomne cierne dvere sa otvorili a vidis pred sebou velmi zvlastne dvere, co tam len je?");
        F = new RoomImpl("Nieco tu nesedi. Je tu hrozny smrad... čo tak hrozne smrdi ? Mozno ze aj tie mrtvoly okolo...");

        // nastav susedov
        F.setExits(C7, null, null, null);
        C7.setExits(C6, F, null, null);
        C6.setExits(C5, C7, null, null);
        C5.setExits(C4, C6, null, null);
        C4.setExits(C3, C5, null, H1);
        C3.setExits(C2, C4, S1, null);
        C2.setExits(C1, C3, null, null);
        C1.setExits(H, C2, null, null);
        H1.setExits(null, null, C4, null);
        S1.setExits(null, null, null, C3);
        H.setExits(A, C1, I, G);
        G.setExits(X, null, H, null);
        I.setExits(B, null, null, H);
        A.setExits(E, H, B, x);
        B.setExits(F1, I, C, A);
        C.setExits(null, null, null, B);
        x.setExits(D, G, A, z);
        z.setExits(null, null, x, y);
        y.setExits(null, null, z, null);
        D.setExits(null, x, E, null);
        E.setExits(J, A, F1, D);
        F1.setExits(m, B, null, E);
        J.setExits(K, E, m, null);
        m.setExits(L, F1, null, J);
        K.setExits(M, J, L, null);
        L.setExits(null, m, N, K);
        N.setExits(null, null, null, L);
        M.setExits(Q, K, null, null);
        Q.setExits(null, M, P, R);
        P.setExits(null, null, O, Q);
        O.setExits(T, null, null, P);
        R.setExits(null, null, Q, S);
        S.setExits(f, null, R, null);
        f.setExits(null, S, null, s);
        s.setExits(null, null, f, w);
        w.setExits(null, null, s, u);
        u.setExits(null, j, w, null);
        j.setExits(u, l, null, null);
        l.setExits(j, null, null, null);
        T.setExits(Y, O, U, null);
        Y.setExits(null, T, null, null);
        U.setExits(null, null, V, T);
        V.setExits(null, null, W, U);
        W.setExits(null, null, X, V);
        X.setExits(null, null, null, W);
             
        // pridaj predmety do miestnosti
        J.addItem( new IronHole());
        m.addItem( new Mace() );
        m.addItem( new Zombie() );
        D.addItem( new Key() );
        F1.addItem( new Chest());
        F1.addItem( new Zombie() );
        A.addItem( new Mine() );
        A.addItem( new Skeleton() );
        x.addItem( new CopperKey());
        z.addItem( new Zombie() );
        z.addItem( new TNT() );
        z.addItem( new Detonator());
        y.addItem( new Skeleton() );
        C.addItem( new SilverKey() );
        C.addItem( new Teleport() );
        K.addItem( new GoldKey() );
        K.addItem( new Skeleton() );
        N.addItem( new DiamondKey() );
        N.addItem( new Zombie() );
        N.addItem( new Skeleton() );
        N.addItem( new Boss() );
        R.addItem( new Shells() );
        R.addItem( new Zombie() );
        f.addItem( new Skeleton() );
        s.addItem( new Mine() );
        j.addItem( new Mine() );
        j.addItem( new Zombie() );
        l.addItem( new Boss() );
        l.addItem( new WoodKey() );
        X.addItem( new SteelChest() );
        Y.addItem( new Skeleton() );
        Y.addItem( new Skeleton() );
        Y.addItem( new Boss() );
        Y.addItem( new DiamondChest() );
        G.addItem( new Skeleton() );
        G.addItem( new Lever() );
        I.addItem( new Zombie() );
        I.addItem( new Mine() ); 
        S1.addItem( new Skeleton() );
        S1.addItem( new Zombie() );
        H1.addItem( new Mine() );
        H1.addItem( new Zombie() );
        H1.addItem( new Shells() );
        H1.addItem( new LockPick() );
        C7.addItem( new Mine() );
        C7.addItem( new Mine() );
        C7.addItem( new Skeleton() );
        C7.addItem( new Zombie() );
        F.addItem( new FinalBoss() );
        F.addItem( new Skeleton() );
        F.addItem( new Zombie() );
        F.addItem( new Skeleton() );
        
        // nastav current room
        setCurrentRoom( E );
        
        getBackpack().getItems().clear();
        getBackpack().add(  new Puta() );
       
    }

    /**
     * Táto metóda vráti referenciu na batoh.
     * @return batoh.
     */
    @Override
    public Backpack getBackpack() 
    {
        return batoh;
    }
}
