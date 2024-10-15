public class MajorityElement {

    // Function to find the majority element
    public static int findMajorityElement(int[] nums) {
        // Step 1: Find the candidate for majority element
        int candidate = findCandidate(nums);

        // Step 2: Verify if the candidate is the majority element
        if (isMajority(nums, candidate)) {
            return candidate;
        } else {
            return -1; // No majority element
        }
    }

    // Step 1: Function to find the potential candidate for majority element
    private static int findCandidate(int[] nums) {
        int count = 0;
        int candidate = -1;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    // Step 2: Function to verify if the candidate occurs more than n/2 times
    private static boolean isMajority(int[] nums, int candidate) {
        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count > nums.length / 2;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Expected Output: 2");
        System.out.println("Actual Output: " + findMajorityElement(nums1));

        // Test Case 2
        int[] nums2 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + findMajorityElement(nums2));

        // Test Case 3
        int[] nums3 = {3, 2, 2, 1, 8};
        System.out.println("Expected Output: -1");
        System.out.println("Actual Output: " + findMajorityElement(nums3));
    }
}
