package catalog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Schema(description = "the id of the book", example = "xxx-123")
    private String isbn10;

    @NotBlank
    @Length(min = 2, max = 255)
    @Schema(description = "the title of the book", example = "Example of everything")
    private String title;

}
