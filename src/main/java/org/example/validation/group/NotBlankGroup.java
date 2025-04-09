package org.example.validation.group;

/**
 * Группа валидации для аннотаций @NotBlank.
 * Используется в последовательности валидации (ValidationOrder),
 * чтобы сначала проверялись пустые поля, а затем длину и формат.
 */
public interface NotBlankGroup {
}
