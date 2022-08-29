public class WebsiteAccesibility {
    public static void main(String[] args){
        try{
            (new java.net.URL("https://google.com")).openStream().close();
            System.out.println("Valid");
        }catch (Exception ex){
            System.out.println("Error: " + ex);
        }
    }
}
