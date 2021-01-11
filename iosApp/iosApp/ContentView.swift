import SwiftUI
import shared
import OSLog
import SwiftUIRefresh


struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel
    @State private var isShowing = false
    init(viewModel: ViewModel) {
        self.viewModel = viewModel
        UITableView.appearance().backgroundColor = .clear
        
    }
    var body: some View {

            listview()
                .pullToRefresh(isShowing: $isShowing) {
                    viewModel.loadPages(force: true) {
                        self.isShowing = false
                    }
            }

    }
    
    func listview() -> AnyView {
        switch viewModel.launches {
        case .loading:
            return AnyView(Text("loading...").multilineTextAlignment(.center))
        case .error(let description):
            return AnyView(Text(description).multilineTextAlignment(.center))
        case .result(let pages):
            return AnyView(List {
                ForEach(pages, id:\.self) { page in
                    RocketLaunchRow(r:page)
                }
                .listRowBackground(Color.blueBg)
                .listRowInsets(EdgeInsets(top: 5, leading: 0, bottom: 5, trailing: 0))
            }
           
            
            )
        }
    }
}

extension ContentView {
    enum LoadableLaunches {
        case loading
        case result([Block])
        case error(String)
    }
    
    class ViewModel: ObservableObject {
        let sdk : Sdk
        @Published var launches = LoadableLaunches.loading
        
        init(sdk: Sdk) {
            self.sdk = sdk
            self.loadPages(force: false, after: { })
        }
        
        
        func loadPages(force: Bool, after: (() -> Void)?) {
            self.launches = .loading
            
            let cb: (KotlinInt)-> Void = { i in
                print("hello got collction \(i.intValue) \(#function)")
                self.update(pos: i.intValue)
            }
            sdk.getPagesFull(blockAtPositionUpdated: cb) { r, e in
                print("got pages r=\(String(describing: r?.count)) e=\(String(describing: e)) func=\(#function)")
                
                if let l = r {
                    self.launches = .result(l)
                } else {
                    self.launches = .error(e?.localizedDescription ?? "error")
                }
                after?()
            }
        }
        func update(pos: Int) {
            switch launches{
            case .result(let b):
                self.launches = .result(b)
                print("update")
                
            default:
                print("\(pos)")
            }
        }
    }
}
extension RocketLaunch: Identifiable {}
extension Block: Identifiable {}
