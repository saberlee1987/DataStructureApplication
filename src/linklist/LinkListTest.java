package linklist;

public class LinkListTest {
    public static void main(String[] args) {
        OrderList orderList = new OrderList();
        System.out.println("Inserted "+orderList.add(7));
        System.out.println("Inserted "+orderList.add(5));
        System.out.println("Inserted "+orderList.add(3));
        System.out.println("Inserted "+orderList.add(8));
        System.out.println("Inserted "+orderList.add(9));
        System.out.println("Inserted "+orderList.add(10));
        System.out.println("Inserted "+orderList.add(2));
        System.out.println("Inserted "+orderList.add(4));
        orderList.show();
        try {
            System.out.println("Deleted : " + orderList.remove(3));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        orderList.show();
        try {
            System.out.println("Deleted : " + orderList.remove(5));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        orderList.show();
        try {
            System.out.println("Deleted : " + orderList.remove(15));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        orderList.show();
    }
}
