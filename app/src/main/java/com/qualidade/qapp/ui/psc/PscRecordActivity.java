package com.qualidade.qapp.ui.psc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.qualidade.qapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static android.view.View.GONE;

public class PscRecordActivity extends AppCompatActivity {
    public static final String EXTRA_PRODUTO =
            "com.qualidade.qapp.psc_bancario.EXTRA_PRODUTO";

    public static final String EXTRA_CLIENTE =
            "com.qualidade.qapp.psc_bancario.EXTRA_CLIENTE";

    public static final String EXTRA_TURNO =
            "com.qualidade.qapp.psc_bancario.EXTRA_TURNO";

    public static final String EXTRA_ITEM =
            "com.qualidade.qapp.psc_bancario.EXTRA_ITEM";

    public static final String EXTRA_QUANTIDADE_A =
            "com.qualidade.qapp.psc_bancario.EXTRA_QUANTIDADE_A";

    public static final String EXTRA_QUANTIDADE_L =
            "com.qualidade.qapp.psc_bancario.EXTRA_QUANTIDADE_L";

    public static final String EXTRA_LINHA =
            "com.qualidade.qapp.psc_bancario.EXTRA_LINHA";

    public static final String EXTRA_ID_ORDEM =
            "com.qualidade.qapp.psc_bancario.EXTRA_ID_ORDEM";

    private PscAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ItemCard> itemCards;
    private int corAtual = Color.parseColor("#EEEEEE");

    private Spinner spinnerClientes;
    private Spinner spinnerTurno;
    private Spinner spinnerLinha;
    private EditText editTextProdutoAudit;
    private EditText editTextID;
    private EditText editTextQtdeLote;
    private EditText editTextQtde;
    private androidx.appcompat.widget.Toolbar psc_toolbar;

    private HashMap<String, ListaItens> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psc_record_scroll);
        setTitle("Auditoria PSC");
        int cor_i = Color.parseColor("#EEEEEE");
        String status_i = "NA";
        carregaSpinners();

        //psc_toolbar = findViewById(R.id.psc_toolbar);
        editTextProdutoAudit = findViewById(R.id.editTextProdutoAudit);
        editTextID = findViewById(R.id.editTextID);
        editTextQtdeLote = findViewById(R.id.editTextQtdeLote);
        editTextQtde = findViewById(R.id.editTextQtde);
        spinnerClientes = findViewById(R.id.spinner_clientes);
        spinnerLinha = findViewById(R.id.spinner_linha);
        spinnerTurno = findViewById(R.id.spinner_turno);

        itemCards = new ArrayList<>();
        itens = new HashMap<>();

        itemCards.add(new ItemCard("1. PERSO/BH/MANUSEIO/AGILI", "Conferência de material", "Conferência dos materiais utilizados.", status_i, cor_i, View.GONE));
        itemCards.add(new ItemCard("2. PERSO/BH/MANUSEIO/AGILI", "Organização", "Na mesa deve ter somente 1 ID para manuseio.", status_i, cor_i, View.GONE));
        itemCards.add(new ItemCard("3. PERSONALIZAÇÃO", "Amostragem", "Qualidade da Personalização gráfica.", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("4. PERSONALIZAÇÃO", "Amostragem", "Qualidade da personalização elétrica, e verificação da realização de teste do Chip.", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("5. PERSONALIZAÇÃO", "Amostragem", "Qualidade de leitura do código de barras da carta berço.", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("6. MANUSEIO (DC/ MX/ BH)", "Impressão", "Qualidade de impressão (Formulários, Carta Berço, Envelopes, Relatórios.)", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("7. MANUSEIO (DC/ MX/ BH)", "Matching", "Matching Processo utilizado para validação dos dados conforme processo definido. (Automático/ Manual/ Dupla Custódia).", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("8. MANUSEIO (DC/ MX/ BH)", "Colagem/ Fechamento de envelopes e void's", "Qualidade de colagem dos produtos.", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("9. MANUSEIO (DC/ MX/ BH)", "Batimento", "Batimento no final da linha (quando aplicável).", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("10. MANUSEIO (DC/ MX/ BH)", "Identificação", "Informações corretas na etiqueta de informações.", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("11. BELL & HOWELL", "Qualidade dos produtos após o envelopamento", "Referente a validacao.", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("12. RETRABALHO (PRODUÇÃO)", "Retrabalhos", "Validado e verificado a descricao do item.", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("13. RETRABALHO (PRODUÇÃO)", "Retrabalhos", "Referente a descricao do item.", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("14. ROTERIZAÇÃO", "Identificação", "Referente a validacao.", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("15. ROTERIZAÇÃO", "Roterização", "Validado e verificado a descricao do item.", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("16. ROTERIZAÇÃO", "Qualidade dos produtos", "Envelopes fechados, Envelopes não grudados, Envelopes não danificados, Ars colados.", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("17. AGILIZAÇÃO DUPLA CUSTÓDIA", "Informações de envio", "Referente a validacao.", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("18. PERSO/BH/MANUSEIO/AGILI", "Prenchimento de registros (Ordem de produção, Check list, Controle no Chrod, Formulários em geral necessários para o processo).", "Valido?", status_i, cor_i, GONE));
        itemCards.add(new ItemCard("19. PERSONALIZAÇÃO (LIMPEZA DAS MÁQUINAS)", "Validar a limpeza das máquinas", "Validado e verificado a descricao do item.", status_i, cor_i, GONE));

        buildRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.psc_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                saveNotePsc();
                return true;

            case R.id.action_cancel:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void carregaSpinners() {
        spinnerClientes = findViewById(R.id.spinner_clientes);
        ArrayAdapter<CharSequence> adapter_clientes = ArrayAdapter.createFromResource(this, R.array.clientes, android.R.layout.simple_spinner_dropdown_item);
        adapter_clientes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClientes.setAdapter(adapter_clientes);

        spinnerTurno = findViewById(R.id.spinner_turno);
        ArrayAdapter<CharSequence> adapter_turno = ArrayAdapter.createFromResource(this, R.array.turno, android.R.layout.simple_spinner_dropdown_item);
        adapter_turno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTurno.setAdapter(adapter_turno);

        spinnerLinha = findViewById(R.id.spinner_linha);
        ArrayAdapter<CharSequence> adapter_linha = ArrayAdapter.createFromResource(this, R.array.linha, android.R.layout.simple_spinner_dropdown_item);
        adapter_linha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLinha.setAdapter(adapter_linha);
    }

    public void buildRecyclerView() {
        recyclerView = findViewById(R.id.psc_rcv);
        layoutManager = new LinearLayoutManager(this);
        adapter = new PscAdapter(itemCards);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new PscAdapter.OnItemClickListener() {
            @Override
            public void onCardClick(int position) {

            }

            @Override
            public void onBtnOKClick(int position) {
                if (itemCards.get(position).getColor() == Color.parseColor("#EEEEEE")) {
                    itemCards.get(position).setColor(Color.parseColor("#93C47D"));
                    itens.put(Integer.toString(position + 1), new ListaItens(Integer.toString(position + 1),"OK"));
                    adapter.notifyItemChanged(position);
                }
                else if (itemCards.get(position).getColor() == Color.parseColor( "#93C47D")) {
                    itemCards.get(position).setColor(Color.parseColor("#EEEEEE"));
                    adapter.notifyItemChanged(position);
                    itens.remove(Integer.toString(position + 1));
                }
            }

            @Override
            public void onBtnNOKClick(int position) {
                if (itemCards.get(position).getColor() == Color.parseColor("#EEEEEE")) {
                    itemCards.get(position).setColor(Color.parseColor("#CC0000"));
                    itens.put(Integer.toString(position + 1), new ListaItens(Integer.toString(position + 1),"NOK"));
                    adapter.notifyItemChanged(position);
                }
                else if (itemCards.get(position).getColor() == Color.parseColor( "#CC0000")) {
                    itemCards.get(position).setColor(Color.parseColor("#EEEEEE"));
                    adapter.notifyItemChanged(position);
                    itens.remove(Integer.toString(position + 1));
                }
            }

            @Override
            public void onBtnClearClick(int position) {
                if (itemCards.get(position).getColor() == Color.parseColor("#EEEEEE")) {
                    itemCards.get(position).setColor(Color.parseColor("#EEEEEE"));
                    adapter.notifyItemChanged(position);
                }
                else if (itemCards.get(position).getColor() == Color.parseColor( "#CC0000")) {
                    itemCards.get(position).setColor(Color.parseColor("#EEEEEE"));
                    adapter.notifyItemChanged(position);
                    itens.remove(Integer.toString(position + 1));
                }
                else if (itemCards.get(position).getColor() == Color.parseColor( "#93C47D")) {
                    itemCards.get(position).setColor(Color.parseColor("#EEEEEE"));
                    adapter.notifyItemChanged(position);
                    itens.remove(Integer.toString(position + 1));
                }
            }
        });
    }

    public void saveNotePsc() {
        String cliente = spinnerClientes.getSelectedItem().toString();
        String linha = spinnerLinha.getSelectedItem().toString();
        String turno = spinnerTurno.getSelectedItem().toString();
        String quantidade_a = editTextQtde.getText().toString();
        String quantidade_l = editTextQtdeLote.getText().toString();
        String id_ordem = editTextID.getText().toString();
        String produto = editTextProdutoAudit.getText().toString();

        if (cliente.trim().isEmpty() || linha.trim().isEmpty() || turno.trim().isEmpty()
                || quantidade_a.trim().isEmpty() || quantidade_l.trim().isEmpty() || id_ordem.trim().isEmpty() || produto.trim().isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_CLIENTE, cliente);
        data.putExtra(EXTRA_ID_ORDEM, id_ordem);
        data.putExtra(EXTRA_TURNO, turno);
        data.putExtra(EXTRA_LINHA, linha);
        data.putExtra(EXTRA_PRODUTO, produto);
        data.putExtra(EXTRA_QUANTIDADE_A, quantidade_a);
        data.putExtra(EXTRA_QUANTIDADE_L, quantidade_l);
        data.putExtra(EXTRA_ITEM, itens);

        setResult(RESULT_OK, data);
        finish();
    }
}