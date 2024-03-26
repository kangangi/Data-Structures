public class StringUtil{

    // Given a string, the task is to check whether given string is a palindrome or not
    public boolean isPalindrome(String word){
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end){
            if (charArray[start] != charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args){
        StringUtil stringUtil = new StringUtil();
        System.out.println(stringUtil.isPalindrome("that"));
    }
}

