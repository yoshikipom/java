package com.yoshikipom.dev.exporter.component;

import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import java.io.File;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyExporterImpl implements MyExporter {
  public static final String BUCKET_NAME = "mybucket";

  private final MinioClient minioClient;

  @Override
  public void execute(File file) {
    try {
      var uploadObject = UploadObjectArgs.builder().bucket(BUCKET_NAME).object("object.json")
          .filename(file.getAbsolutePath()).contentType("application/json").build();
      minioClient.uploadObject(uploadObject);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
