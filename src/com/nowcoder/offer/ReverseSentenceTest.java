package com.nowcoder.offer;


/*
 * JOBDU最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentenceTest {
	public String ReverseSentence(String str) {
		if (str == null || str.length() <= 1) {
			return str;
		}
		String[] strings = str.split(" ");
		StringBuilder builder = new StringBuilder();
		for (int i = strings.length - 1; i >= 0; i--) {
			builder.append(strings[i]);
			builder.append(' ');
		}
		if (builder.length() > 0)
			builder.deleteCharAt(builder.length() - 1);
		return builder.toString();

	}

	public String ReverseSentence1(String str) {
		if (str == null || str.length() <= 1) {
			return str;
		}
		char[] ch = str.toCharArray();
		reserve(ch, 0,ch.length-1);
		for(int i=0;i<ch.length;i++){
			int j=i;
			for(;j<ch.length&&ch[j]!=' ';j++);
			reserve(ch, i, j-1);
			i=j;
		}
		return new String(ch);
	}

	private void reserve(char[] ch, int begin, int end) {
		while(begin<end){
			char tmp=ch[begin];
			ch[begin]=ch[end];
			ch[end]=tmp;
			end--;
			begin++;
		}
	}

	public static void main(String[] args) {
		String aString = "d .d";
		ReverseSentenceTest tes = new ReverseSentenceTest();
		System.out.println(tes.ReverseSentence1(aString));
	}
}
