import java.util.List;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 */
class TopK {
    private static int[] array = { 1, 1, 1, 2, 2, 3 };

    static Timer timer = new Timer();

    public static void main(String[] args) {
        // print(topKFrequent(array, 2));
        test();
        adb();
    }

    private static void adb() {
        Process process = null;
		String osName = System.getProperty("os.name ");
        String command = "/Users/andy/Developer/AndroidSdk/platform-tools/adb shell input swipe 250 1500 250 800 5000";   //sdk所在位置
		try{
            process=Runtime.getRuntime().exec(command);
            InputStreamReader ir  =new InputStreamReader(process.getInputStream());
            LineNumberReader input= new LineNumberReader(ir);
            String line;
            while((line=input.readLine())!=null)
            System.out.println(line);
		}catch(IOException e){
		    System.err.println("IOException"+e.getMessage());
		}
		System.out.println(osName+"/n");
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<Integer, Integer>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }

    public static void print(List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }

    public static void test() {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("wtf");
            }
        };

        // 延迟 1s 打印 wtf 一次
        // timer.schedule(task, 1000);
        // 延迟 1s 固定时延每隔 1s 周期打印一次 wtf
        timer.schedule(task, 1000, 10000);
    }

}