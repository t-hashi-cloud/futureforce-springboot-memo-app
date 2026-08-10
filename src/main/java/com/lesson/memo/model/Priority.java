package com.lesson.memo.model;//パッケージ宣言


public enum Priority {
	HIGH("高"),//HIGHはプログラムで使う　高は画面に表示させる文字
    MEDIUM("中"),
    LOW("低");
	
	private final String label;
	//labelは「高中低」を保存する変数。HIGH→ label = "高"　MEDIUM→ label = "中"
	//コンストラク
	private Priority(String label) {
        this.label = label;
    }
	
    //labelを取り出す関数
	//Priority priority = Priority.HIGH;
	//↓
	//priority.getLabel();
	//↓
	//"高"
    public String getLabel() {
        return this.label;
    }
}