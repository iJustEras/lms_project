package lms_project.content;

public class ContentFactory {
    public static IContent createContent(String type, String title) {
        switch (type.toLowerCase()) {
            case "quiz":
                return new Quiz(title);
            case "assignment":
                return new Assignment(title);
            case "material":
                return new Material(title);
            default:
                throw new IllegalArgumentException("Unknown content type");
        }
    }
}
