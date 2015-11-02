package cn.saymagic.weixin.server.handler;

import cn.saymagic.weixin.server.bean.MsgRequest;

public class EventHandler extends BaseHandler {
	@Override
	public String doHandleMsg(MsgRequest msgRequest) {
		if (!"event".equals(msgRequest.getMsgType()))
			return null;
		else if ("subscribe".equals(msgRequest.getEvent())) {
			return getResponseStringByContent("欢迎关注。", msgRequest);
		} else if ("CLICK".equals(msgRequest.getEvent())) {
			String eventKey = msgRequest.getEventKey();
			String content = "";
			content = "Click Menu" + msgRequest.getEventKey();
			return getResponseStringByContent(content, msgRequest);
		} else {
			return getResponseStringByContent("请求无效，稍后再试。", msgRequest);
		}

	}
}