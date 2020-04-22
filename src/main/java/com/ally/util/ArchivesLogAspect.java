package com.ally.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Method;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.sevenlog.bean.SevenLog;
import com.ally.sevenlog.service.SevenLogService;

@Aspect
@Component
public class ArchivesLogAspect {

	@Autowired
	private SevenLogService sevenLogService;
	
    @SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ArchivesLog.class);

    @Pointcut("@annotation(ArchivesLog)")
    public void controllerAspect() {
        //System.out.println("切入点...");
    }

    
    /**
     * 方法调用后触发 , 记录正常操作
     * 
     * @param joinPoint
     * @throws ClassNotFoundException 
     * @throws UnknownHostException 
     */
    @AfterReturning("controllerAspect()")
    public  void after(JoinPoint joinPoint) throws ClassNotFoundException, UnknownHostException {
            // 用户id
            int userId = getUSerMsg().getId();
            // 用户IP
            InetAddress  address=InetAddress.getLocalHost();
            String ip = address.getHostAddress();
            // 操作方法
            String methodName = getMethodDesc(joinPoint).getlType();
            // 操作说明
            String operteContent = getMethodDesc(joinPoint).getlContent();
            
            SevenLog logInfo = new SevenLog();
            //操作时间
            SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		String format = dFormat.format(System.currentTimeMillis());
    		try {
    			logInfo.setlDatetime(dFormat.parse(format));
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            logInfo.setlAid(userId);
            logInfo.setlIp(ip);
            logInfo.setlContent(operteContent);
            logInfo.setlType(methodName);
            sevenLogService.insertLog(logInfo);
    }

    
    
    /**
     * 获取 注解中对方法的描述
     * 
     * @return
     * @throws ClassNotFoundException
     */
    public static SevenLog getMethodDesc(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String operteContent = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    operteContent = method.getAnnotation(ArchivesLog.class).operteContent();
                    break;
                }
            }
        }
        SevenLog logInfo = new SevenLog();
        logInfo.setlType(methodName);
        logInfo.setlContent(operteContent);
        return logInfo;
    }

    
    /**
     * 得到用户信息
     * 
     * @return
     */
    public static SevenAccount getUSerMsg() {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 获取session
        HttpSession session = req.getSession();
        SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
        return sevenAccount;
    }
    
}
