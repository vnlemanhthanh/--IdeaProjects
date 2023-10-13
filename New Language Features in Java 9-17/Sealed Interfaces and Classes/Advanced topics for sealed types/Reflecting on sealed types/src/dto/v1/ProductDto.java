package dto.v1;

public sealed interface ProductDto permits ComputerDto, ChairDto {
  long id();
}
