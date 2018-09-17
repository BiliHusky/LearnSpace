package advice;

import java.sql.SQLException;

/**
 * Created by yjw on 18-9-14.
 */
public class ForumService {
    public void removeForum(int forumId) {
        //....
        throw new RuntimeException("runtime error");
    }

    public void updateForum(Forum forum) throws SQLException {
        //...
        throw new SQLException("update sql error");
    }
}
