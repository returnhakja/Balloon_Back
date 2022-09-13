package com.balloon.api;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.balloon.service.S3ServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class S3Controller {

	private final S3ServiceImpl s3Svc;

	@PostMapping("/upload/profile")
	public ResponseEntity<String> uploadProfile(@RequestParam(value = "file") MultipartFile multiFile) {
		System.out.println("dddddddddddddd");
		System.out.println(multiFile);
		System.out.println("dddddddddddddd");
		return new ResponseEntity<>(s3Svc.uploadProfile(multiFile), HttpStatus.OK);
	}

	@GetMapping("/download/{fileName}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
		byte[] data = s3Svc.downloadFile(fileName);
		ByteArrayResource resource = new ByteArrayResource(data);
		return ResponseEntity.ok().contentLength(data.length).header("Content-type", "application/octet-stream")
				.header("Content-disposition", "attachment; filename=\"" + fileName + "\"").body(resource);
	}

	@DeleteMapping("/delete/{fileName}")
	public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
		return new ResponseEntity<>(s3Svc.deleteFile(fileName), HttpStatus.OK);
	}
}
