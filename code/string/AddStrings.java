import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
class AddStrings {
    public static void main(String[] args) {

        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        Set<String> set = new HashSet<>();
        set.add("1");


        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("");


        List list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }

        // 第一种
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            new ArrayList<>();
        }
        long end = System.currentTimeMillis();
        System.out.println("第一种 for int：time = " + (end - start));

        // 第二种
        start = System.currentTimeMillis();
        for (Object object : list) {
            new ArrayList<>();
            object.hashCode();
        }
        end = System.currentTimeMillis();
        System.out.println("第二种 foreach ：time = " + (end - start));

        // 第三种
        start = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            new ArrayList<>();
            int i = iterator.next();
        }
        end = System.currentTimeMillis();
        System.out.println("第三种 iterator ：time = " + (end - start));
    }

    

}