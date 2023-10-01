package BoardSw;

public class BoardVO {
	private int idx;
	private String category;
	private String title;
	private String content;
	private String displayYN;
	private String reportYN;
	private int likes;
	private String writedate;
	private String nickName;
	private int viewCnt;
	private String image;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDisplayYN() {
		return displayYN;
	}
	public void setDisplayYN(String displayYN) {
		this.displayYN = displayYN;
	}
	public String getReportYN() {
		return reportYN;
	}
	public void setReportYN(String reportYN) {
		this.reportYN = reportYN;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", category=" + category + ", title=" + title + ", content=" + content
				+ ", displayYN=" + displayYN + ", reportYN=" + reportYN + ", likes=" + likes + ", writedate="
				+ writedate + ", nickName=" + nickName + ", viewCnt=" + viewCnt + ", image=" + image + "]";
	}
}
