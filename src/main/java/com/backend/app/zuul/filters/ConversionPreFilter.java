package com.backend.app.zuul.filters;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;


import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ConversionPreFilter extends ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(ConversionPreFilter.class);

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		//String jsonStr = request.getParameter("id");
//		String jsonStr = String.format("{car : { id: %s, name: %s, marca: %s, color: %s } }", request.getParameter("id"),request.getParameter("name"),request.getParameter("marca"),request.getParameter("color"));
//		JSONObject json = new JSONObject(jsonStr);
//		String xml = XML.toString(json);
//		request.setAttribute("xmlStr", xml);
//		log.info(String.format("Cadena XML: %s", xml));
		try (final InputStream responseDataStream = ctx.getResponseDataStream()){
			if(responseDataStream == null) {
				log.info("BODY: {}", "");
				request.setAttribute("respuesta","");
				return null;
			}
			String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));
			log.info("BODY: {}",responseData);
			request.setAttribute("respuesta",responseData);
			ctx.setResponseBody(responseData);
		}
		catch (Exception e) {
			throw new ZuulException(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
		return null;
	}

	@Override
	public String filterType() {
		
		return "pre";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
