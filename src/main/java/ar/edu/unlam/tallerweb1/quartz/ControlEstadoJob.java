package ar.edu.unlam.tallerweb1.quartz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ControlEstadoJob extends QuartzJobBean {
	
    	private HttpServletRequest request;
    
		@Override
		protected void executeInternal(JobExecutionContext jobContext) throws JobExecutionException {
			try {
				ApplicationContext appCtx =(ApplicationContext) jobContext.getScheduler().getContext().get("applicationContext");
				
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  System.out.println("prueba");
		}
		 
	}
