import java.util.ArrayList;
import java.util.List;

/**
 * Formats elements as table
 * @param <P>
 */
class Table<P> {
	private class Entry {
		private int height;
		private int width;
		private String[] object;

		public int getHeight() {
			return height;
		}

		public int getWidth() {
			return width;
		}

		public Entry(P object) {
			this.object = object.toString().split("\n");
			this.height = this.object.length;
			this.width = 0;

			for (String line : this.object) {
				this.width = Math.max(this.width, line.length());
			}
		}

		public String render(int line, int width) {
			int entryWidth = 0;
			StringBuilder b = new StringBuilder();

			if (line < object.length) {
				b.append(object[line]);
				entryWidth = object[line].length();
			}

			assert entryWidth <= width;

			for (int i = 0; i < width - entryWidth; ++i) {
				b.append(' ');
			}

			return b.toString();
		}
	}

	private List<ArrayList<Entry>> objects;
	private int[] widths;

	/**
	 * @param o non empty rectangular array
	 */
	public Table(P[][] o) {
		objects = new ArrayList<ArrayList<Entry>>(o.length);
		for (P[] line : o) {
			ArrayList<Entry> items = new ArrayList<Entry>(line.length);

			for (P object : line) {
				items.add(new Entry(object));
			}

			objects.add(items);
		}

		// calculate the widths for the table
		this.widths = calculateWidths();
	}

	/**
	 * Render out the table.
	 * @return
	 */
	public String renderTable() {
		if (objects.size() < 1) {
			return "";
		}
		
		int w = objects.get(0).size();
		int h = objects.size();
		
		return renderTable(w, h);
	}
	
	/**
	 * Render out the table.
	 * 
	 * @param w >= 0
	 * @param h >= 0
	 * @return
	 */
	public String renderTable(int w, int h) {
		if (objects.size() < 1) {
			return "";
		}

		int maxY = objects.size();
		int maxX = objects.get(0).size();

		// create the table
		StringBuilder b = new StringBuilder();
		for (int y = 0; y < h; ++y) {
			List<Entry> line = objects.get(y % maxY);

			// calculate row height
			int rowHeight = 0;
			for (Entry e : line) {
				rowHeight = Math.max(rowHeight, e.getHeight());
			}

			// render it out
			for (int lineIndex = 0; lineIndex < rowHeight; ++lineIndex) {
				for (int x = 0; x < w; ++x) {
					String item = line.get(x % maxX).render(lineIndex,
							widths[x % maxX]);
					b.append(item);
				}

				b.append("\n");
			}
		}

		return b.toString();
	}

	private int[] calculateWidths() {
		int[] widths = new int[objects.get(0).size()];
		for (List<Entry> line : objects) {
			int index = 0;

			for (Entry e : line) {
				widths[index] = Math.max(widths[index], e.getWidth());
				index++;
			}
		}
		return widths;
	}
}