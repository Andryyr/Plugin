import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.NotNull;
import utils.IconUtil;

public class ToodlesAction extends AnAction {

    public ToodlesAction() {
        super(IconUtil.GOOGLE_LOGO);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Editor editor = CommonDataKeys.EDITOR.getData(e.getDataContext());
        String selectedText = editor == null ? "" : editor.getSelectionModel().getSelectedText();
        if (selectedText == null || StringUtil.isEmptyOrSpaces(selectedText))
        {
            return;
        }

        System.out.println(selectedText);
        BrowserUtil.browse("http://google.com/search?q=" + selectedText);
    }
}
