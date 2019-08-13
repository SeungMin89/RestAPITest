package com.simplify.sample.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.slf4j.LoggerFactory;

public class SignInController {
		private static final Logger Logger = LoggerFactory.getLogger(SignInController.class);
		
		@Autowired
		private SignInService signInService;
		
		@Autowired
		private TalkService talkService;
		
		/*
		 * 로그인 인증 검증 철
		 * @param request
		 * @param response
		 * @param requestBody
		 * @return
		 */
	
		String wdrwAcctNo = "";
		String haiBkngNtryYn = "";
		String mbphEnprByDvCd = "";
		String mbphNo = "";
		String mbleCustStCd = "";
		String mbleSignInCheck = "";
		
		
		Map<String, Object> haiBankResultMap = new LinkedHashMap<String, Object>();
		haiBankResultMap = signInService.haiBankResultCheck(restNm, step, param);
		
		Set<String> step5Info = haiBankResultMap.keySet();
		
		for (String returnKey : step5Info) {
			if (returnKey.equals("repStatusCode")) {
				//rest response 코드정보
				apiMessage = (ApiResponseMessage) haiBankResultMap.get(returnKey);
				
				Logger.info("REST_NM=[[}] STEP=[{}] Status=[{}] error_code=[{}] error_message=[{}]", restNM, step5Info, apiMessage.getStatus(), apiMessage.getErrorCode(), apiMessage.getErrorMessage());
			}	else if (returnKey.equals("wdrwAcctNo")) {
				// 출금계좌번호(비밀번호 검증시 사용)
				wdrwAcctNo = haiBankResultMap.get(returnKey).toString();
				param.put("wdrwAcctNo", wdrwAcctNo.replace("-", ""));				
			}	else if (returnKey.equals("haiBkngNtryYn")) {
				// HAI 뱅킹 가입 여부 값 (db에 넣을 값)
				haiBkngNtryYn = haiBankResultMap.get(returnKey).toString();
				param.put("haiBkngNtryYn", haiBkngNtryYn);				
			}	else if (returnKey.equals("mbphEnprByDvCd")) {
				// 통신사 코드정보
				mbphEnprByDvCd = haiBankResultMap.get(returnKey).toString();
				param.put("mbphEnprByDvCd", mbphEnprByDvCd);		
			}	else if (returnKey.equals("mbphNo")) {
				// 휴대전화번호
				mbphNo = haiBankResultMap.get(returnKey).toString();
				param.put("mbphNo", mbphNo);		
			}	else if (returnKey.equals("mbleCustStCd")) {
				// 이용정지 고객 코드
				mbleCustStCd = haiBankResultMap.get(returnKey).toString();
				param.put("mbleCustStCd", mbleCustStCd);		
			}	else if (returnKey.equals("mbleSignInCheck")) {
				// 인증 완료 여부 값
				mbleSignInCheck = haiBankResultMap.get(returnKey).toString();
				param.put("mbleSignInCheck", mbleSignInCheck);		
			}
		}
}
