package cn.saymagic.weixin.server.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "msg_response_text")
public class MsgResponseText extends MsgResponse {

	private static final long serialVersionUID = 4956088110027867013L;

	@DatabaseField(width = 1000)
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
