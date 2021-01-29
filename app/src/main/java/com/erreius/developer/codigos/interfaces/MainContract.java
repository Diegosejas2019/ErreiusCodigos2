package com.erreius.developer.codigos.interfaces;

import com.erreius.developer.codigos.Model.User;

import java.util.ArrayList;

public interface MainContract {

    interface View{
        void onCreatePlayerSuccessful();
        void onCreatePlayerFailure();
        void onProcessStart();
        void onProcessEnd();
        /*void onPlayerRead(ArrayList<Player> players);
        void onPlayerUpdate(Player player);
        void onPlayerDelete(Player player);*/
    }

    interface Presenter{
        void createNewPlayer(User user);
        void readPlayers(User user);
        /*void updatePlayer(DatabaseReference reference, Player player);
        void deletePlayer(DatabaseReference reference, Player player);*/
    }

    interface Ineractor{
        void performCreatePlayer(User user);
        void performReadPlayers(User user);
        /*void performUpdatePlayer(DatabaseReference reference,Player player);
        void performDeletePlayer(DatabaseReference reference, Player player);*/
    }

    interface onOperationListener{
        void onSuccess();
        void onFailure();
        void onStart();
        void onEnd();
        /*void onRead(ArrayList<Player> players);
        void onUpdate(Player player);
        void onDelete(Player player);*/
    }
}
