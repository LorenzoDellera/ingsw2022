package it.polimi.ingsw.network.client;

import it.polimi.ingsw.controller.client.ClientController;
import it.polimi.ingsw.network.communication.NotificationVisitor;
import it.polimi.ingsw.network.communication.notification.*;
import it.polimi.ingsw.view.View;

/**
 * This class is used by the {@link ClientController} to handle a message sent by the server.
 * It implements visitor patter to dispatch {@link Notification} and perform different action on the view.
 */
public class ClientSideVisitor implements NotificationVisitor {

    private final View view;
    private String nickname;

    public ClientSideVisitor(View view) {
        this.view = view;
    }

    @Override
    public void visit(LoginNotification msg) {
        //TODO
    }

    @Override
    public void visit(WinNotification msg) {
        view.win(msg.getName(), msg.isWin());
    }

    @Override
    public void visit(CloudsNotification msg) {
        view.showClouds(msg.getCloudList());
    }

    @Override
    public void visit(MoveStudentNotification msg) {
        //TODO: check this
        view.moveStudent(msg.getMovableColor());
    }

    @Override
    public void visit(MoveMNNotification msg) {
        view.moveMNature(msg.getSteps());
    }

    @Override
    public void visit(ChooseCloudNotification msg) {
        view.chooseCloud(msg.getAvailableClouds());
    }

    @Override
    public void visit(ChooseGameModeNotification msg) {
        view.chooseGameMode();
    }

    @Override
    public void visit(SchoolNotification msg) {
        if(msg.getOwner().equals(nickname))
            view.showSchool(msg.getSchool());
        else
            view.showOtherSchool(msg.getSchool());
    }

    @Override
    public void visit(BoardNotification msg) {
        view.showBoard(msg.getBoard());
    }

    @Override
    public void visit(DisconnectionNotification msg) {
        view.showDisconnection(msg.getNickname());
    }

    @Override
    public void visit(ChooseWizAndTowerColorNotification msg) {
        view.chooseWizardAndTowerColor(msg.getAvailableWizards(),msg.getAvailableColors());
    }

    @Override
    public void visit(ChooseAssistantNotification msg) {
        view.chooseAssistant(msg.getPlayableAssistant());
    }

    @Override
    public void visit(NicknameErrorNotification msg) {
        //TODO: add a method to say that provided nickname was already used
        view.setNickname(); //this will just re-ask name
    }

    @Override
    public void visit(EventNotification msg) {
        view.showMessage(msg.getMessage());
    }

    @Override
    public void visit(GameStartedNotification msg) {
        // view.updateScreen()
        view.showMessage(msg.getMessage());
    }

    @Override
    public void visit(GenericMessageNotification msg) {
        view.showMessage(msg.getMessage());
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
