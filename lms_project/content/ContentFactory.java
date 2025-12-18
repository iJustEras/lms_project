package lms_project.content;

public class ContentFactory {
    private static ContentFactory instance;

    public static ContentFactory getInstance() {
        if (instance == null) {
            instance = new ContentFactory();
        }

        return instance;
    }

    public IContent createContent(String type, String title) {
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
