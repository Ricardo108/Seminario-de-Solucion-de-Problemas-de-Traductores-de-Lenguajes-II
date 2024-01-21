import re

class AnalizadorLexico:
    def __init__(self, input_text):
        self.input_text = input_text
        self.tokens = []

    def analyze(self):
        while self.input_text:
            self.input_text = self.input_text.lstrip()

            # Identificadores
            if re.match(r'^[a-zA-Z][a-zA-Z0-9]*', self.input_text):
                match = re.match(r'^[a-zA-Z][a-zA-Z0-9]*', self.input_text)
                identifier = match.group()
                self.tokens.append((identifier, 0))
                self.input_text = self.input_text[match.end():]

            # Entero
            elif re.match(r'^\d+', self.input_text):
                match = re.match(r'^\d+', self.input_text)
                integer = match.group()
                self.tokens.append((integer, 1))
                self.input_text = self.input_text[match.end():]

            # Real
            elif re.match(r'^\d+\.\d+', self.input_text):
                match = re.match(r'^\d+\.\d+', self.input_text)
                real = match.group()
                self.tokens.append((real, 2))
                self.input_text = self.input_text[match.end():]

            # Operadores y caracteres especiales
            elif re.match(r'^[+\-*/=<>!;,\(\){}]', self.input_text):
                match = re.match(r'^[+\-*/=<>!;,\(\){}]', self.input_text)
                symbol = match.group()

                if symbol == '+':
                    self.tokens.append((symbol, 5))
                elif symbol == '-':
                    self.tokens.append((symbol, 5))
                elif symbol == '*':
                    self.tokens.append((symbol, 6))
                elif symbol == '/':
                    self.tokens.append((symbol, 6))
                elif symbol in ('<', '<=', '>', '>=', '!=', '=='):
                    self.tokens.append((symbol, 7))
                elif symbol == '||':
                    self.tokens.append((symbol, 8))
                elif symbol == '&&':
                    self.tokens.append((symbol, 9))
                elif symbol == '!':
                    self.tokens.append((symbol, 10))
                elif symbol == ';':
                    self.tokens.append((symbol, 12))
                elif symbol == ',':
                    self.tokens.append((symbol, 13))
                elif symbol == '(':
                    self.tokens.append((symbol, 14))
                elif symbol == ')':
                    self.tokens.append((symbol, 15))
                elif symbol == '{':
                    self.tokens.append((symbol, 16))
                elif symbol == '}':
                    self.tokens.append((symbol, 17))
                elif symbol == '=':
                    self.tokens.append((symbol, 18))

                self.input_text = self.input_text[match.end():]

            # Palabras reservadas
            elif re.match(r'^(if|while|return|else|int|float)$', self.input_text):
                match = re.match(r'^(if|while|return|else|int|float)', self.input_text)
                keyword = match.group()

                if keyword == 'if':
                    self.tokens.append((keyword, 19))
                elif keyword == 'while':
                    self.tokens.append((keyword, 20))
                elif keyword == 'return':
                    self.tokens.append((keyword, 21))
                elif keyword == 'else':
                    self.tokens.append((keyword, 22))
                elif keyword in ('int', 'float'):
                    self.tokens.append((keyword, 4))

                self.input_text = self.input_text[match.end():]

            else:
                print(f"Error: No se pudo reconocer el siguiente token: {self.input_text[0]}")
                break

        # Agregar token de fin de archivo
        self.tokens.append(('$', 23))

if __name__ == "__main__":
    input_text = "if (x < 5) { return x * 2; } else { return x + 2; }"
    
    lexer = AnalizadorLexico(input_text)
    lexer.analyze()

    for token, token_type in lexer.tokens:
        print(f"Token: {token}, Tipo: {token_type}")
