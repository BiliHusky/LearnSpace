package anno;

/**
 * Created by yjw on 18-9-17.
 */
public class ForumService {
    @NeedTest(value = true)
    public void deleteForum(int forumId) {
        System.out.println("delete forum : " + forumId);
    }

    @NeedTest(value = false)
    public void deleteTopic(int postId) {
        System.out.println("delete forum topic : " + postId);
    }
}
