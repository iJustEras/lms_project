package lms_project.user_services;

import lms_project.users.*;

import java.util.*;

import javax.swing.*;
import java.awt.*;

public class UserNotification extends JFrame {

    private static final Map<AppUser, ArrayList<Notification>> notificationsMap = new HashMap<>();

    // Called when a user is enrolled
    public static void registerUser(AppUser user) {
        notificationsMap.putIfAbsent(user, new ArrayList<>());
    }

    // Called by Course (Observer update)
    public static void notifyUser(AppUser user, Notification notification) {
        notificationsMap.computeIfAbsent(user, k -> new ArrayList<>()).add(notification);
    }

    // Called when user logs in
    public static void showUnreadNotifications(AppUser user, Component parent) {
        ArrayList<Notification> notifications = notificationsMap.get(user);

        if (notifications == null || notifications.isEmpty()) return;

        StringBuilder text = new StringBuilder("New notifications:\n\n");
        boolean hasUnread = false;

        for (Notification n : notifications) {
            if (!n.isRead()) {
                text.append("• ").append(n.getMessage()).append("\n");
                n.markAsRead();
                hasUnread = true;
            }
        }

        if (hasUnread) {
            JOptionPane.showMessageDialog(
                parent,
                text.toString(),
                "Notifications",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
