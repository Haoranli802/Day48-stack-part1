class Solution {
    public int[] dailyTemperatures(int[] T) {
    int length = T.length;
    int[] result = new int[length];

    //从右向左遍历
    for (int i = length - 2; i >= 0; i--) {
        // j+= result[j]是利用已经有的结果进行跳跃
        for (int j = i + 1; j < length; j+= result[j]) {
            if (T[j] > T[i]) {
                result[i] = j - i;
                break;
            } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                result[i] = 0;
                break;
            }
        }
    }
        return result;
    }
}

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        if(temperatures.length == 1) return res;
        Deque<Integer> temperature = new ArrayDeque<>();
        for(int i = 0; i < temperatures.length; i++){
            if(temperature.isEmpty() || temperatures[i] < temperatures[temperature.peek()]){
                temperature.push(i);
            }
            else{
                while(!temperature.isEmpty() && temperatures[i] > temperatures[temperature.peek()]){
                    int index = temperature.pop();
                    res[index] = i - index;
                }
                temperature.push(i);
            }
        }
        return res;
    }
