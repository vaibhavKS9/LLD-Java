package BuilderPattern;

class User {

    public String name;
    public String email;


    private User(Builder builder){
        this.name=builder.name;
        this.email=builder.email;
    }
    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        public String email;
        public String name;

        public Builder(){
            //
        }

        public Builder setName(String name){
            this.name=name;
            return this;
        }
        public Builder setEmail(String email){
            this.email=email;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }

    @Override
    public String toString(){
        return " name: "+this.name+" email "+this.email;
    }

}


public class BuilderPatternDemo {
    
    public static void main(String[] args){
        User user1=User.builder()
                    .setName("Vaibhav")
                    .setEmail("Vaibhav@gmail.com")
                    .build();
        User user2=User.builder()
                    .setName("Karan")
                    .setEmail("Karan@gmail.com")
                    .build();

        System.out.println("user1 "+user1);
        System.out.println("user2 "+user2);
    }

}
