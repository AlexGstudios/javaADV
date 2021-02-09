public class Player{

    GameGui gui = Game.gui;

    public void firstRoom(){

        gui.setShowRoom(Game.rooms[0].show(0));
    }

    public void secondRoom(){

        gui.setShowRoom(Game.rooms[1].show(1));
    }

    public void thirdRoom(){

        gui.setShowRoom(Game.rooms[2].show(2));
    }

    public void fourthRoom(){

        gui.setShowRoom(Game.rooms[3].show(3));
    }
}