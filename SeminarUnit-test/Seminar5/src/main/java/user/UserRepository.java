package user;

public class UserRepository {
    public String getUserById(int id){
        // В реальной жизни здесь был бы код, работающий с БД
        return "User " + id;
    }
}
