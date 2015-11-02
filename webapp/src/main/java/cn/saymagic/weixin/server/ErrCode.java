package cn.saymagic.weixin.server;

import java.util.HashMap;
import java.util.Map;

public class ErrCode {

	private static Map<String, String> codeMap = new HashMap<String, String>();

	static {
		codeMap.put("-1", "ϵͳ��æ");
		codeMap.put("0", "����ɹ�");
		codeMap.put("40001", "��ȡaccess_tokenʱAppSecret���󣬻���access_token��Ч");
		codeMap.put("40002", "���Ϸ���ƾ֤����");
		codeMap.put("40003", "���Ϸ���OpenID");
		codeMap.put("40004", "���Ϸ���ý���ļ�����");
		codeMap.put("40005", "���Ϸ����ļ�����");
		codeMap.put("40006", "���Ϸ����ļ���С");
		codeMap.put("40007", "���Ϸ���ý���ļ�id");
		codeMap.put("40008", "���Ϸ�����Ϣ����");
		codeMap.put("40009", "���Ϸ���ͼƬ�ļ���С");
		codeMap.put("40010", "���Ϸ��������ļ���С");
		codeMap.put("40011", "���Ϸ�����Ƶ�ļ���С");
		codeMap.put("40012", "���Ϸ�������ͼ�ļ���С");
		codeMap.put("40013", "���Ϸ���APPID");
		codeMap.put("40014", "���Ϸ���access_token");
		codeMap.put("40015", "���Ϸ��Ĳ˵�����");
		codeMap.put("40016", "���Ϸ��İ�ť����");
		codeMap.put("40017", "���Ϸ��İ�ť����");
		codeMap.put("40018", "���Ϸ��İ�ť���ֳ���");
		codeMap.put("40019", "���Ϸ��İ�ťKEY����");
		codeMap.put("40020", "���Ϸ��İ�ťURL����");
		codeMap.put("40021", "���Ϸ��Ĳ˵��汾��");
		codeMap.put("40022", "���Ϸ����Ӳ˵�����");
		codeMap.put("40023", "���Ϸ����Ӳ˵���ť����");
		codeMap.put("40024", "���Ϸ����Ӳ˵���ť����");
		codeMap.put("40025", "���Ϸ����Ӳ˵���ť���ֳ���");
		codeMap.put("40026", "���Ϸ����Ӳ˵���ťKEY����");
		codeMap.put("40027", "���Ϸ����Ӳ˵���ťURL����");
		codeMap.put("40028", "���Ϸ����Զ���˵�ʹ���û�");
		codeMap.put("40029", "���Ϸ���oauth_code");
		codeMap.put("40030", "���Ϸ���refresh_token");
		codeMap.put("40031", "���Ϸ���openid�б�");
		codeMap.put("40032", "���Ϸ���openid�б���");
		codeMap.put("40033", "���Ϸ��������ַ������ܰ���\\uxxxx��ʽ���ַ�");
		codeMap.put("40035", "���Ϸ��Ĳ���");
		codeMap.put("40038", "���Ϸ��������ʽ");
		codeMap.put("40039", "���Ϸ���URL����");
		codeMap.put("40050", "���Ϸ��ķ���id");
		codeMap.put("40051", "�������ֲ��Ϸ�");
		codeMap.put("41001", "ȱ��access_token����");
		codeMap.put("41002", "ȱ��appid����");
		codeMap.put("41003", "ȱ��refresh_token����");
		codeMap.put("41004", "ȱ��secret����");
		codeMap.put("41005", "ȱ�ٶ�ý���ļ�����");
		codeMap.put("41006", "ȱ��media_id����");
		codeMap.put("41007", "ȱ���Ӳ˵�����");
		codeMap.put("41008", "ȱ��oauth code");
		codeMap.put("41009", "ȱ��openid");
		codeMap.put("42001", "access_token��ʱ");
		codeMap.put("42002", "refresh_token��ʱ");
		codeMap.put("42003", "oauth_code��ʱ");
		codeMap.put("43001", "��ҪGET����");
		codeMap.put("43002", "��ҪPOST����");
		codeMap.put("43003", "��ҪHTTPS����");
		codeMap.put("43004", "��Ҫ�����߹�ע");
		codeMap.put("43005", "��Ҫ���ѹ�ϵ");
		codeMap.put("44001", "��ý���ļ�Ϊ��");
		codeMap.put("44002", "POST�����ݰ�Ϊ��");
		codeMap.put("44003", "ͼ����Ϣ����Ϊ��");
		codeMap.put("44004", "�ı���Ϣ����Ϊ��");
		codeMap.put("45001", "��ý���ļ���С��������");
		codeMap.put("45002", "��Ϣ���ݳ�������");
		codeMap.put("45003", "�����ֶγ�������");
		codeMap.put("45004", "�����ֶγ�������");
		codeMap.put("45005", "�����ֶγ�������");
		codeMap.put("45006", "ͼƬ�����ֶγ�������");
		codeMap.put("45007", "��������ʱ�䳬������");
		codeMap.put("45008", "ͼ����Ϣ��������");
		codeMap.put("45009", "�ӿڵ��ó�������");
		codeMap.put("45010", "�����˵�������������");
		codeMap.put("45015", "�ظ�ʱ�䳬������");
		codeMap.put("45016", "ϵͳ���飬�������޸�");
		codeMap.put("45017", "�������ֹ���");
		codeMap.put("45018", "����������������");
		codeMap.put("46001", "������ý������");
		codeMap.put("46002", "�����ڵĲ˵��汾");
		codeMap.put("46003", "�����ڵĲ˵�����");
		codeMap.put("46004", "�����ڵ��û�");
		codeMap.put("47001", "����JSON/XML���ݴ���");
		codeMap.put("48001", "api����δ��Ȩ");
		codeMap.put("50001", "�û�δ��Ȩ��api");
		codeMap.put("61451", "��������(invalid parameter)");
		codeMap.put("61452", "��Ч�ͷ��˺�(invalid kf_account)");
		codeMap.put("61453", "�ͷ��ʺ��Ѵ���(kf_account exsited)");
		codeMap.put("61454",
				"�ͷ��ʺ������ȳ�������(������10��Ӣ���ַ���������@��@��Ĺ��ںŵ�΢�ź�)(invalid kf_acount length)");
		codeMap.put("61455",
				"�ͷ��ʺ��������Ƿ��ַ�(������Ӣ��+����)(illegal character in kf_account)");
		codeMap.put("61456", "�ͷ��ʺŸ�����������(10���ͷ��˺�)(kf_account count exceeded)");
		codeMap.put("61457", "��Чͷ���ļ�����(invalid file type)");
		codeMap.put("61450", "ϵͳ����(system error)");
		codeMap.put("61500", "���ڸ�ʽ����");
		codeMap.put("61501", "���ڷ�Χ����");
	}

	public static String errMsg(Integer errCode) {
		if (errCode != null && codeMap.containsKey(errCode + "")) {
			return codeMap.get(errCode + "");
		}
		return null;
	}

}