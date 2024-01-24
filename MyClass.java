import java.io.*;
import java.util.*;

class User{
    String topic;
    String user;
    User(String topic, String user){
        this.topic = topic;
        this.user = user;
    }
}

class Review{
    User topic;
    String name;
    String type;
    String date;
    Review(User topic, String name, String type, String date){
        this.topic = topic;
        this.name = name;
        this.type = type;
        this.date = date;
    }
}

public class MyClass {
    
    static List<User> topic_list = new ArrayList<User>();
    static List<Review> review_l = new ArrayList<>();
    static HashMap<User, Integer> max_ne = new HashMap<>();
    
    public static void main(String args[]) {
        User u1 = new User("topic1", "u1");
        topic_list.add(u1);
        User u2 = new User("topic2", "u2");
        topic_list.add(u2);
        User u3 = new User("topic3", "u3");
        topic_list.add(u3);

        // Scanner sc = new Scanner();
        // System.out.print("Enter no of reviews:");
        // var n = sc.nextInt();
        // for(int i=0; i<n;i++){
        //     System.out.print("Enter topic:")
        // }

        Review r1 = new Review(u1, "AAA", "positive", "24-01-2024");
        review_l.add(r1);
        Review r2 = new Review(u1, "BBB", "positive", "20-01-2024");
        review_l.add(r2);
        Review r3 = new Review(u1, "CCC", "negative", "23-01-2024");
        review_l.add(r3);
        Review r4 = new Review(u1, "DDD", "negative", "19-01-2024");
        review_l.add(r4);
        Review r5 = new Review(u1, "EEE", "negative", "15-01-2024");
        review_l.add(r5);

        int n=0;
        // String

        for(Review e:review_l){
            String date = e.date;
            if(date.substring(3,5).equals("01")){
                if(e.type.equals("negative")){
                    if(max_ne.containsKey(e.topic)){
                        n = max_ne.get(e.topic);
                        n+=1;
                        max_ne.replace(e.topic, n);
                    } else{
                        n+=1;
                        max_ne.put(e.topic, n);
                    }
                }
            }
            
        }

        User max_ne_user = Collections.max(max_ne.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("User with maximum negative reviews: "+max_ne_user.user);
        n = max_ne.get(max_ne_user);
        System.out.println("Maximum negative reviews:" + n);




      
    }
}