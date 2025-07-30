//approach-I generate a unique hash for each string by assigning a distinct prime number to each alphabet. For each string, I compute its hash by multiplying the primes corresponding to its characters(index 0-25 corresponds to 26 aplhabets). Since anagrams contain the same characters, they produce the same product (hash). I use a hash map to group all strings with the same hash together. In the end, I return the values of the map, which are lists of anagrams.

//time complexity -(O(k*n))k being the length of each string and n being the length of list of strings. This is because I am iterating each of the strings in the list and for each stringi am iterating  to each of the characters and my get prime numbers function is being only called once but still runs in constant time.

//space complexity- O(n) n being the length of strength since we are storing all the strings in the list in the hash map. and additional space being used here the is the area of prime numbers which is a constant.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     int[] hashSet=getPrimeNumbers(26);//string contains only lowercase 
     HashMap<Double,List<String>> map=new HashMap<>();
     for(String str:strs){
        double hash=getHash(hashSet,str);
        if(map.containsKey(hash)){
            map.get(hash).add(str);
        }
        else {
            List<String> list=new ArrayList<>();
            list.add(str);
            map.put(hash,list);
        }
     }
     return new ArrayList<>(map.values());

    }

    private double getHash(int[] hashSet,String s){
        double hash=1;
        for(int i=0;i<s.length();i++){
            hash=hash*hashSet[s.charAt(i)-'a'];
        }
        return hash;
    }

    
     private static int[] getPrimeNumbers(int n){
        int[] result=new int[n];
        int count=0;
        int i=2;
        while(count<n){
            if(isPrime(i)){
                result[count]=i;
                count++;
            }
            i++;
        }
        return result;
    }

    private static boolean isPrime(int num) {
        for (int j = 2; j *j<= num; j++) {
            if(num%j==0)return false;
        }
        return true;
    }
}
