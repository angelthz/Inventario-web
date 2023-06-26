package com.athz.servlets;

import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MonitoreoFiltro implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.printf("1. Servlet: Monitoreo \n");
		Long inicio = System.currentTimeMillis();
		chain.doFilter(request, response);
		Long fin = System.currentTimeMillis();
		System.out.println("Tiempo transcurrido: "+(fin-inicio));
	}

}
