package com.nowcoder.interview;
/*
 * 有一个排过序的字符串数组，但是其中有插入了一些空字符串，请设计一个算法，找出给定字符串的位置。算法的查找部分的复杂度应该为log级别。
	给定一个string数组str,同时给定数组大小n和需要查找的string x，请返回该串的位置(位置从零开始)。
	测试样例：
	["a","b","","c","","d"],6,"c"
	返回：3
 */
public class FindStringWithBlank {
	public int findString(String[] str, int n, String x) {
		if(str==null||str.length==0)
			return -1;
		int begin=0;
		int end=n-1;
		int mid=0;
		while(begin<=end){
			mid=begin+(end-begin)/2;
			if(str[mid].equals("")){
				mid++;
				while(str[mid].equals("")){
					mid++;
					if(mid>=end)
						return -1;
				}
			}
			if(str[mid].equals(x))
				break;
			if(str[mid].compareTo(x)<0){
				begin=mid+1;
			}else {
				end=mid-1;
			}
		}
		if(str[mid].equals(x))
			return mid;
		return -1;
    }

	public static void main(String[] args) {
		String[] aStrings={"","","","","","","AECOGS","AOOFYXQ","AQ","AVMMTXNXRA","BAXEVHLYME",
				"BCA","BUV","BVTPMOLHLC","BX","CBDHCOMI","CDWGWW","CLG","CODB","CWKIYFYHNIY",
				"CZA","D","DEMJMHQYMC","DFLYAK","DRR","DVMVXK","EIHULX","EOTCMEXHH",
				"ETYGMD","EXXHWDPS","GNVM","GVEBGEFC","HEFVFXDND","HOUUXMYVC","IDPNQI",
				"IIODZQF","IVPD","JEGHXQCTTNT","JJXNXIYGH","JZBCHVIHK","LIDN","LLKIIAZ",
				"MCBFFHFJBLT","MRTYDDIM","MVWD","N","NJBXRKL","NLEMZIZ","NMMQL","NQQRGMAN",
				"NUO","O","OBC","ONES","OPP","OXOPR","Q","QBZNAE","QCK","QGR","QKLUDC",
				"RWASPGXEUJY","TDDWTG","TER","TTZK","TV","UGUJUEU","UIQYOL","USQENKTCEGJ","UZ","V","VDGRM","VNEFQVOGRYX","VQNFRIPQR","WHLNXPTCPAI","WNYVMOYJBCY","WSZQBUGJO","WVPZVAWYJJ","X","XMTDBDND","XPANBKVAKB","XTPYTK","Y","ZUDJMEVLQJN"};
		FindStringWithBlank blank=new FindStringWithBlank();
		System.out.println(blank.findString(aStrings, aStrings.length, "TER"));
	}
}
