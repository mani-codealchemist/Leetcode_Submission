
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int[] days = {31, 28, 31, 30, 31, 30,
                      31, 31, 30, 31, 30, 31};

        int count = 0;

        for (int month = 1; month <= 12; month++) {
            for (int day = 1; day <= days[month - 1]; day++) {

                String date = String.format("%02d-%02d", month, day);

                if (date.compareTo(arriveAlice) >= 0 &&
                    date.compareTo(leaveAlice) <= 0 &&
                    date.compareTo(arriveBob) >= 0 &&
                    date.compareTo(leaveBob) <= 0) {

                    count++;
                }
            }
        }

        return count;
    }
}
