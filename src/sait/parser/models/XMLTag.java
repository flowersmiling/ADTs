package sait.parser.models;

/**
 * XML Tag class
 */
public class XMLTag 
{
	/**
	 *Tag name 
	 */
	private String tagName;
	/**
	 *line number the Tag located 
	 */
	private int lineNum;
	/**
	 *Tag type:Start_Tag,End_Tag,Self_Closing_Tag
	 */
	private String tagType;
	
	/**
	 * XML Tag class constructor
	 * @param tagName
	 * @param lineNum
	 * @param tagType
	 */
	public XMLTag(String tagName, int lineNum, String tagType) 
	{
		super();
		this.tagName = tagName;
		this.lineNum = lineNum;
		this.tagType = tagType;
	}

	/** 
	* Get Tag Name 
	* @return - tagname
	*/
	
	public String getTagName() {
		return tagName;
	}

	/** 
	* Set Tag Name
	* @param tagName
	*/
	
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	/** 
	* Get Tag line number in the XML file 
	* @return
	*/
	
	public int getLineNum() {
		return lineNum;
	}

	/** 
	* Set line number 
	* @param lineNum
	*/
	
	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	/** 
	* Get Tag type 
	* @return
	*/
	
	public String getTagType() {
		return tagType;
	}

	/** 
	* Set Tag type 
	* @param tagType
	*/
	
	public void setTagType(String tagType) {
		this.tagType = tagType;
	}
}
