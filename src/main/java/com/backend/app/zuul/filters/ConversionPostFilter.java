package com.backend.app.zuul.filters;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ConversionPostFilter extends ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(ConversionPostFilter.class);

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		log.info("Entrando a filtro ConversionPost");
		String respuesta = (String) request.getAttribute("respuesta");
		//String tipo = ((Object)xmlStr).getClass().getSimpleName();
		if(respuesta instanceof String) {
			log.info("El formato es correcto");
		}else {
			log.info("El formato no es correcto");
		}
		
	
		return null;
	}

	@Override
	public String filterType() {
		
		return "post";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
