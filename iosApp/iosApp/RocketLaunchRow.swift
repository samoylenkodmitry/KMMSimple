//
//  RocketLaunchRow.swift
//  iosApp
//
//  Created by Дмитрий Самойленко on 06.01.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared
import Kingfisher

struct RocketLaunchRow: View {
    var rocketLaunch: Block
    init(r: Block) {
        print("new row")
        rocketLaunch = r
    }
    var body: some View {
        VStack(alignment: .leading, spacing: 0.0, content: {
            Text("\(rocketLaunch.title ?? "")")
                .lineLimit(1)
                .font(.system(size: 20, weight: .heavy, design: .default))
                .foregroundColor(Color.white)
                .padding(EdgeInsets(top:10,leading: 10,bottom: 10,trailing: 0))
            
            ScrollView(.horizontal) {
                LazyHStack(alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/, spacing: 0.0, pinnedViews: /*@START_MENU_TOKEN@*/[]/*@END_MENU_TOKEN@*/, content: {
                    
                    let c = collectionCount
                    if (c > 0) {
                        let mv: [Movie] = movies ?? []
                        ForEach(0...(c-1), id: \.self) { pos in
                            MoviewView(pos: pos, mv: mv)
                                .padding(EdgeInsets(top:0,leading: 10, bottom: 0,trailing: 0))
                        }
                    }
                })
            }
        })
    }
}
extension Color {
    static let blueBg = Color("blueBg")
    static let blueFg = Color("blueFg")
    static let text = Color("text")
    static let blackOpac = Color("blackOpac")
}
extension RocketLaunchRow {
    private var movies: [Movie]? {
        return rocketLaunch.collection?.component1()
    }
    private var collectionCount: Int {
        return movies?.count ?? 0
    }
}

struct PosterImageView: View {
    var url: String
    var pos: Int
    var body: some View {
        
        KFImage(URL(string: url)!)
            .resizable()
            .onSuccess { r in
                print(" succc: \(pos) - \(r.cacheType)")
            }
            .onFailure { e in
                print(" err: \(pos) - \(e)")
            }
            .placeholder {
                Image(systemName: "arrow.2.circlepath.circle")
                    .resizable()
                    .frame(width: PosterImageView.w, height: PosterImageView.h, alignment: .center)
                    .padding(0)
                    .foregroundColor(.blue)
            }
            .cancelOnDisappear(true)
            .aspectRatio(contentMode: .fit)
            .cornerRadius(5.0)
            .frame(width: PosterImageView.w, height: PosterImageView.h, alignment: .center)
            .padding(0)
            .animation(.linear(duration: 0.4))
        
        
    }
}
extension PosterImageView {
    static let w:CGFloat = 140.0
    static let h:CGFloat = w * 360.0 / 234.0
}

struct MoviewView: View {
    var pos: Int
    var mv: [Movie]
    var body: some View {
        VStack() {
            let v = mv[pos]
            let url: String? = v.posterOriginals?[0].component1() ?? nil
            if (url != nil) {
                let urlnn: String = "\(url!)/234x360/"
                ZStack(alignment: .bottomTrailing) {
                    PosterImageView(url: urlnn, pos: pos)
                    
                    Text("\(v.restrict_ ?? 0)+")
                        .background(Color.blackOpac)
                        
                }
            }
            Text("\(v.title ?? "")")
                .frame(minWidth: 0, idealWidth: PosterImageView.w, maxWidth: PosterImageView.w, minHeight: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, idealHeight: 20, maxHeight: 20, alignment: .leading)
                .lineLimit(1)
                .font(.system(size: 16, weight: .semibold, design: .default))
                .foregroundColor(Color.text)
            Text("\(v.paidSubtitle())")
                .frame(minWidth: 0, idealWidth: PosterImageView.w, maxWidth: PosterImageView.w, minHeight: /*@START_MENU_TOKEN@*/0/*@END_MENU_TOKEN@*/, idealHeight: 14, maxHeight: 14, alignment: .leading)
                .lineLimit(1)
                .font(.system(size: 12, weight: .semibold, design: .default))
                .foregroundColor(getColor(pt: v.primaryType()))
        }
    }
}
extension MoviewView {
    func getColor(pt: PaidTypes) -> Color {
        switch pt {
        case PaidTypes.est:
            return Color("textEst")
        case PaidTypes.svod:
            return Color("textSvod")
        
        default:
            return Color("textAvod")
        }
    }
}
