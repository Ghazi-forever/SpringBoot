package com.orders.service;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CompressionFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String compressionHeader = request.getHeader("X-Compression");

        if ("GZIP".equals(compressionHeader)) {
            // Decompress the response data
            response = decompressResponse(response);
        }

        filterChain.doFilter(request, response);
    }

    private HttpServletResponse decompressResponse(HttpServletResponse response) throws IOException {
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(response);
        wrapper.setHeader("Content-Encoding", "gzip"); // Set content encoding for decompression

        // Implement the decompression logic here. Spring Boot will handle this if the response is compressed.

        return wrapper;
    }
}
