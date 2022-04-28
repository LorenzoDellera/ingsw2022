package it.polimi.ingsw.network.communication.notification;

import it.polimi.ingsw.model.place.ShortSchool;
import it.polimi.ingsw.network.communication.NotificationVisitor;

import java.io.Serial;
import java.util.List;

/**
 * This notification is used by the server to show a school to a client
 */
public class SchoolNotification extends Notification {
    @Serial
    private static final long serialVersionUID = -1083964897097839635L;

    private final List<ShortSchool> schoolList;

    public SchoolNotification(List<ShortSchool> schoolList) {
        this.schoolList = schoolList;
    }

    @Override
    public void accept(NotificationVisitor visitor) {
        visitor.visit(this);
    }

    public List<ShortSchool> getSchool() {
        return schoolList;
    }
}
