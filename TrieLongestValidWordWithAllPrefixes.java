/**
** Ref: https://www.geeksforgeeks.org/longest-valid-word-with-all-prefixes/
** https://www.youtube.com/watch?v=m9zawMC6QAI
**  Given an array of N strings words[]. Find longest string in words[] such that such that every prefix of it is also in words[]. If there are multiple answers print the lexicographically shortest string.

Examples:

Input: words = {“a” , “banana” , “app” , “apply” , “ap” , “appl” , “apple”}
Output: apple
Explanation:

For the first string “a”, only prefix is “a” and it is present in the words[] array, so this is a valid string.
For the second string “banana”, prefixes are: “b”, “ba”, “ban”, “bana”, “banan” and “banana”, but no prefix other than “banana” is present in words[] array.
For the third string “app”, prefixes are: “a”, “aa” and “aap” and all the prefixes are present in words[] array, so this is a valid string.
For the fourth string “apply”, prefixes are: “a”, “ap”, “app”, “appl” and “apply” but prefix “apply” is not present in the words[] array.
For the fifth string “ap”, prefixes are: “a” and “ap” and both the prefixes are present in words[], so this is a valid string.
For the sixth string “appl”, prefixes are: “a”, “ap”, “app” and “appl” and all the prefixes are present in words[], so this is a valid string.
For the seventh string “apple”, prefixes are: “a”, “ap”, “app”, “appl” and “apple” and all the prefixes are present in words[], so this is a valid string.
Among all the valid strings, “apply” and “apple” are longest string having all the prefixes in words. Furthermore, “apple” is lexicographically smaller so “apple” is the answer.

** Approach: Since we need to populate prefix and then check, we know each node of trie represents Prefix.
** We can save all words in Trie.
** Since each prefix must exist in dictionary, traverse Trie and 
**/
