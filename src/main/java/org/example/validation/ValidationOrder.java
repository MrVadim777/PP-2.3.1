package org.example.validation;

import org.example.validation.group.EmailGroup;
import org.example.validation.group.NotBlankGroup;
import org.example.validation.group.SizeGroup;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * Последовательность групп валидации:
 * 1. NotBlank - сначала проверка на пустые поля
 * 2. Size     - потом длина значений
 * 3. Email    - и только затем формат email
 * Это что бы избежать дублирующих сообщений об ошибках.
 */
@GroupSequence({NotBlankGroup.class, SizeGroup.class, EmailGroup.class, Default.class})
public interface ValidationOrder {
}
