O controller `AgendaController` foi movido para o pacote `controller` (arquivo:
`src/controller/AgendaController.java`).

Motivo:
- Evitar duplicação de controllers e conflitos entre pacotes `service` e `controller`.

Ação tomada:
- Mantivemos um comentário explicativo no antigo local (`src/service/AgendaController.java`) para não quebrar referências externas ao arquivo.
- O arquivo arquivado foi criado inicialmente em `src/service/removed/AgendaController.java`.
- A pedido do usuário, o arquivo arquivado foi removido (conteúdo limpo) em 29/11/2025.

Se quiser que eu recupere o conteúdo arquivado em outro arquivo ou commit, posso restaurá-lo a partir do histórico.
