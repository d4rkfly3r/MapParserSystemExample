package net.d4rkfly3r.maps.info;

public class Author {

    private final String authorName;
    private final String authorUsername;

    public Author(final String authorName, final String authorUsername) {

        this.authorName = authorName;
        this.authorUsername = authorUsername;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorName='" + authorName + '\'' +
                ", authorUsername='" + authorUsername + '\'' +
                '}';
    }
}
