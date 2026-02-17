class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int mid = s.length() / 2;
        int count1 = 0, count2 = 0;

        for (int i = 0; i < mid; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1)
                count1++;
        }

        for (int i = mid; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1)
                count2++;
        }

        return count1 == count2;
    }
}
